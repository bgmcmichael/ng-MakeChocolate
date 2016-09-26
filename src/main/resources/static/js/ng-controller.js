angular.module('TIYChocolateApp', [])
   .controller('TIYChocolateController', function($scope, $http, $timeout) {
        $scope.makeArray = function(arraySize) {
            var returnArray = [];
            for (var i = 0; i < arraySize; i++) {
                returnArray.push(i);
            }
            console.log(returnArray);
            return returnArray;
        }

        $scope.getSolution = function(smalls, bigs, goal) {
            console.log("About to go get me some data!");
            $http.get("http://make-chocolate-tiy.herokuapp.com/makeChocolate.json?smalls=" + smalls + "&bigs=" + bigs + "&goal=" + goal)
                .then(
                    function successCallback(response) {
                        console.log(response.data);
                        console.log("Adding data to scope");
                        tempSolution = response.data;
                        if (tempSolution.hasSolution){
                            $scope.solution = tempSolution;
                            $scope.guess.bigs = bigs - $scope.solution.bigs;
                            $scope.guess.smalls = smalls - $scope.solution.smalls;
                        } else {
                            $scope.solution = tempSolution;
                        }
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
        };
        $scope.guess = {};
        console.log("controller intialized");
   });