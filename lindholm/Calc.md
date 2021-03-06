## Instructions for trying out DrAST on the Calc compiler ##

Calc is a small language used for teaching. The CalcExample directory contains source code for a frontend compiler implemented in JastAdd for this language. The compiler parses a Calc program, pretty-prints the program, and computes and prints any compile-time errors.

### Run the compiler tests ###

Before trying out DrAST, you should run the compiler tests to make sure it builds and runs correctly on your system:

    > cd CalcExample
    > ant test

This will generate the compiler (by running jflex, beaver, and jastadd), and run tests for the compiler (tests for parsing, ast building, name analysis, and prettyprinting). It is normal that there are some warnings, but all tests should run successfully, and the output from this command should end with `BUILD SUCCESSFUL`.

Next, build the `compiler.jar` by

    > ant jar

The output from this command should also end with `BUILD SUCCESSFUL`. You can now try out the compiler by running it one of the example calc programs that are included (the same as the one shown in Section 2 in the paper):

    > java -jar compiler.jar CalcExamples/intro.calc

The compiler will prettyprint the program, and print out compile-time errors (in this case, a variable `y` is not declared).

The compiler main program has been prepared to work with DrAST by adding a static variable `DrAST_root_node`, which is set in the `main` method to refer to the AST of the compiled program. This amounts to two lines of code that has been added to the compiler. If you would like to see the difference, compare the following two files:

    > diff src/java/lang/Compiler.java \
    ../CalcExample-DrAST-files/Compiler.java.orig

### Start DrAST on the Calc compiler ###

 In the following, we will assume that you are in the `CalcExample` directory when you run DrAST. Note also that DrAST will save some configuration files in the directory you start it from.

Start DrAST:

    > java -jar ../DrAST.jar

The interactive tool will start, and a dialog box will be opened where you fill in:

* Path to compiler jar: `compiler.jar`
* First compiler argument: `CalcExamples/intro.calc`

Leave the other fields empty, and click on `Open`. DrAST will now run `compiler.jar` on the `intro.calc` program and show the resulting AST in the window. Initially, an autogenerated filter program will be used which filters away all nodes, so only one cluster of all nodes is shown. In the console pane at the bottom, you will see the same output as when running the compiler from the command line (including the error message about the undeclared variable `y`).

To show all nodes, edit the filter program (shown to the right in the window) to the following code:

    configs{
        use = showall;
    }
    filter showall{
        :ASTNode{}
    }

and click on `Apply filter` (or `ctrl-S`).

All nodes in the program should now be shown, and the window should look similar to the one in Figure 1 in the paper.

You can exit DrAST by the menu command `File -> Exit`. DrAST has saved three files in the directory you started from:

* `DrAST.cfg` --- general settings for DrAST
* `DrASTGUI.cfg`--- settings for the GUI of DrAST, includes the paths to the latest used compiler, compiled program, and filter program.
* `filter.fcl`--- the filter program

When you start DrAST again (`java -jar ../DrAST.jar`), you can simply click `Open` directly in the dialog box if you would like to run it on the same compiler and program, and with the same filter program.

### Interacting with the AST ###

Experiment a little with interacting with the AST:

* Zoom in and out by scrolling (scrollwheel, or two-finger stroke on Apple trackpad), or by using the `+` and `-` buttons on the horizontal bar above the AST.
* Pan by using middle mouse button (the scrollwheel), or `ctrl` and left mouse button, or `ctrl` and hold down on trackpad.
* Select a node by clicking on it (left mouse button or trackpad).
* Move a node by clicking and dragging it.
* (If you happen to come into a state where you cannot see any nodes, e.g. because of zooming and panning, click on the `Root node` button on the horizontal bar above the AST. This will place the root node in the center.)

Try selecting an `IdUse` node by clicking on it. The names and values of the node's attributes are shown in the left pane. An `IdUse` node represents the use of an identifier, and has a `decl` attribute that points to its declaration node. Experiment with looking at attributes:

* Click on the `decl` attribute in the left pane to see which node it points to in the AST. The node pointed to (an `IdDecl` in this case) will light up in green, and a green arrow to it will be displayed.

* A JastAdd compiler evaluates only the attributes it needs to compile that particular program. There may be many more attributes. An unevaluated attribute has the text `right click to compute` in the value field. Try evaluating one of these attributes. (If you use an Apple trackpad, tap with two fingers to emulate a right mouse click.)

* JastAdd supports parameterized attributes, and for those, you have to supply a parameter when you evaluate them. As an example, evaluate the `lookup(String)` attribute of an `IdUse` node, giving another name than the one in the `IdUse` node. You will see what declaration the node would have been bound to if it had had that name.

### Filtering the AST ###

We may be interested in viewing only some of the AST nodes. The filter program can be used to specify that only nodes of specific types should be displayed, or only those with specific attribute values. We can also use the filter program to specify that some attribute values are shown directly in the displayed AST.

Start by changing the filter program so that it only shows `Let`, `IdDecl`, and `IdUse` nodes. You can do this by adding a new filter `showsome`, and changing what filter is `use`d, as follows:

    configs{
        use = showsome;
    }
    filter showall{
        :ASTNode{}
    }
    filter showsome{
        :Let{}
        :IdDecl{}
        :IdUse{}
    }

As before, click on `Apply filter` to make it take effect on the AST. You will see that other nodes are collapsed into cluster nodes.

(We can note that also the `UnknownDecl` node is shown, and this is because `UnknownDecl` is a subclass of `IdDecl`. You can see this by clicking on the `UnknownDecl` node, and its class hierarchy is shown in the upper part of the left pane.)

(All names from the grammar are escaped in the filter language by using a preceding colon, so they will not conflict with the keywords in the filter language.)

Now, we would also like to see the names of the uses and declarations. If you click on an `IdUse` and an `IdDecl` you will see that both have a token attribute for this called `getID`. Change the filter program so that these attributes are shown:

    ...
    filter showsome{
        :Let{}
        :IdDecl{show{:getID;}}
        :IdUse{show{:getID;}}
    }

To finish this example, we would also like to see the `decl` reference attributes, i.e., to which `IdDecl` node the `decl` attribute points to for each `IdUse` node. We could do this by adding `decl` to the existing `showsome` filter (`show{:getID;:decl;}`), or we could add new filter `shownamebindings`, and `use` both of them, like this:

    configs{
        use = showsome, shownamebindings;
    }
    filter showall{
        :ASTNode{}
    }
    filter showsome{
        :Let{}
        :IdDecl{show{:getID;}}
        :IdUse{show{:getID;}}
    }
    filter shownamebindings{
        :IdUse{show{:decl;}}
    }

The resulting view looks a little jumbled because the layout does not take the reference attribute links into account. But if you move around the nodes a little bit, you will get the same view as in Figure 2 in the paper.

### Conditional filtering ###

We can use attributes to do conditional filtering, for example to only show nodes whose attributes have specific values. Instead of having a powerful filtering language to accomplish this, we rely on the attributes themselves. If there are boolean attributes, you can use them directly for conditional filtering. If you would like to express something more complex, you can always add a boolean attribute to the compiler that computes the desired property, using the powerful formalism that the attribute grammar itself constitutes.

To exemplify this, we will show how we can filter the AST to show only those IdUses that are lacking a declaration, i.e., those for which the `decl` attribute points to the `UnknownDecl` node.

To do this, we will extend the compiler by adding a new JastAdd file `DrASTadditions.jrag` to the `src/jastadd` directory in the compiler source code. This file adds a boolean attribute `isUndeclared` to the `IdUse` class as follows:

    aspect ForExposingInDrAST {
        syn boolean IdUse.isUndeclared() = decl().isUnknown();
    }

You can add it by copying it from the extra files directory:

    cp ../CalcExample-DrAST-files/DrASTadditions.jrag src/jastadd

Then rebuild the compiler jar file:

    ant jar

Note that you don't have to exit DrAST. You can just run the compiler again by the menu command `File -> Run compiler again`.

Now you can change the filter to only show those `IdUses` that are undeclared, by adding a `when {:isUndeclared;}` clause to one of the `:IdUse` clauses, for example, as follows:

    filter shownamebindings{
        :IdUse{when {:isUndeclared;}show{:decl;}}
    }

After `Apply filter` the AST will only show those `IdUse` nodes that are undeclared. Other `IdUse` nodes are collapsed into the cluster nodes.

### Look at another program ###

You can easily switch what compiled program to visualize. Just open another program file by doing the menu command `File -> Open` and change the first compiler argument. For example, you can look at the program `CalcExamples/large.calc` which is a larger Calc program.