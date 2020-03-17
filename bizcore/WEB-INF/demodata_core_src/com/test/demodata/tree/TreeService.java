package com.test.demodata.tree;


import com.test.demodata.DemodataUserContext;
import com.test.demodata.BaseEntity;

public interface TreeService {
    //load the subtree which root is node id/node type, and only one tree found.
    Node loadTree(DemodataUserContext ctx, String nodeId, String nodeType) throws Exception;

    default Node loadTree(DemodataUserContext ctx, BaseEntity pEntity) throws Exception {
        return loadTree(ctx, pEntity.getId(), pEntity.getInternalType());
    }

    default Node loadTree(DemodataUserContext ctx, String nodeId, Class nodeClass) throws Exception {
        return loadTree(ctx, nodeId, nodeClass.getSimpleName());
    }

    Node loadAncestors(DemodataUserContext ctx, String nodeId, String nodeType) throws Exception;

    default Node loadAncestors(DemodataUserContext ctx, BaseEntity pEntity) throws Exception {
        return loadAncestors(ctx, pEntity.getId(), pEntity.getInternalType());
    }

    default Node loadAncestors(DemodataUserContext ctx, String nodeId, Class nodeClass) throws Exception {
        return loadAncestors(ctx, nodeId, nodeClass.getSimpleName());
    }

    default Node addChild(DemodataUserContext ctx, Node tree, BaseEntity pEntity) throws Exception {
        return addChild(ctx, tree, pEntity.getId(), pEntity.getInternalType());
    }

    //add child in the tree as current node's last son, returns the parent
    Node addChild(DemodataUserContext ctx, Node tree, String childId, String childType) throws Exception;

    default Node addChild(DemodataUserContext ctx, Node tree, String childId, Class childType) throws Exception {
        return addChild(ctx, tree, childId, childType.getSimpleName());
    }

    Node deleteChild(DemodataUserContext ctx, Node parent, Node child) throws Exception;
}

