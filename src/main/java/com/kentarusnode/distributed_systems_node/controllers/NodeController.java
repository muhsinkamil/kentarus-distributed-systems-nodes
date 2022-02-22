package com.kentarusnode.distributed_systems_node.controllers;

import com.kentarusnode.distributed_systems_node.constants.ConfigConstants;
import com.kentarusnode.distributed_systems_node.constants.ResponseConstants;
import com.kentarusnode.distributed_systems_node.services.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {
    @Autowired
    NodeService nodeService;

    @PatchMapping(value = "/node")
    public String nodeMaster(@RequestParam("action") String action) {
        // If the node is already disabled
        if (action.equals(ConfigConstants.disable) && nodeService.getStatus() == -1) {
            return ResponseConstants.NOK;
        }
        nodeService.changeStatus();
        return ResponseConstants.OK;
    }

    @GetMapping(value = "/nodes/status")
    public int nodeHealthChecker() {
        return nodeService.getStatusOfNode();
    }
}
