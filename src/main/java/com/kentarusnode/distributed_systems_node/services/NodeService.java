package com.kentarusnode.distributed_systems_node.services;

import org.springframework.stereotype.Service;

@Service
public class NodeService {
    private int status = 1;

    public int getStatusOfNode() {
        return this.status;
    }

    public void changeStatus() {
        this.status = -1 * this.status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
