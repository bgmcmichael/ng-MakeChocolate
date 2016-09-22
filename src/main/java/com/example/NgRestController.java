package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenji on 9/22/2016.
 */
@RestController
public class NgRestController {
    @RequestMapping(path = "/makeChocolate.json", method = RequestMethod.GET)
    public ChocolateSolution getSolution(int smalls, int bigs, int goal){
       // ChocolateSolution guess = ((ChocolateSolution)session.getAttribute("guess"));
        ChocolateSolver solver = new ChocolateSolver();
        ChocolateSolution solution = solver.makeChocolate(smalls, bigs, goal);

        return solution;
    }
}
