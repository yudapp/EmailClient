package com.mainemail;

import com.mainemail.model.EmailAccount;
import javafx.scene.control.TreeItem;

/**
 * Implementing the java fx tree view for email folders
 */

public class EmailManager {

    private TreeItem<String> foldersRoot = new TreeItem<>("");
    public TreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    //pass email account information
    public void addEmailAccount(EmailAccount emailAccount){
        TreeItem<String> treeItem = new TreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        //get the children of the tree item (email address)
        treeItem.getChildren().add(new TreeItem<String>("Inbox")); //add a child to the Email Tree Item
        foldersRoot.getChildren().add(treeItem);
    }

}
