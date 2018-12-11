package com.molvenolakeresort.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Include this interface to have a set of standard functions. (mainly used for testing purposes)
 */
public interface ControllerPingTest {

    /**
     * Default test to check if controller is available.
     * @return pong response on ping.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    default public String ping()
    {
        return "pong";
    }
}
