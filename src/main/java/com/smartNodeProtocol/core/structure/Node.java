package com.smartNodeProtocol.core.structure;

import com.smartNodeProtocol.core.visitors.NodeVisitor;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface Node {

    <RESULT, DATA> RESULT accept(NodeVisitor<RESULT, DATA> visitor, DATA data);
}
