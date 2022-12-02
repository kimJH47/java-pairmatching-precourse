package pairmatching.controller;

import pairmatching.service.PairMatchingService;
import pairmatching.view.ViewResolver;

public class PairMatchingController {
    private final PairMatchingService pairMatchingService;
    private final ViewResolver viewResolver;

    public PairMatchingController(PairMatchingService pairMatchingService, ViewResolver viewResolver) {
        this.pairMatchingService = pairMatchingService;
        this.viewResolver = viewResolver;
    }

}
