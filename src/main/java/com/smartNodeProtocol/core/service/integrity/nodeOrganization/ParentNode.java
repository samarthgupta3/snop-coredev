package com.smartNodeProtocol.core.service.integrity.nodeOrganization;

import com.smartNodeProtocol.core.structure.Node;

import java.util.List;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface ParentNode<T extends Node> extends Node{

    List<T> getChildNodes() ;

}
