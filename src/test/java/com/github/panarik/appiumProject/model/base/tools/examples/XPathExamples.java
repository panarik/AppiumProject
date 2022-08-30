package com.github.panarik.appiumProject.model.base.tools.examples;

public class XPathExamples {

    // Find view
    private static final String VIEW_ANY = "//*"; // Find view with any class
    private static final String VIEW_CLASS = "//androidx.recyclerview.widget.RecyclerView"; // Find view by class name.

    // Find class parameters
    private static final String PARAMETER_TEXT = "//*[@text='some text']"; // Find all have some text.
    private static final String PARAMETER_CLASS = "//*[@class='android.widget.TextView']"; // Find all TextView's.
    private static final String PARAMETER_TEXT_CONTAINS = "//*[contains(@text,'some text')]"; // Find all contains some text.

    // Or operator
    private static final String TEXT_OR_LABEL_1 = "//*[@text='foo' or @label='foo']";
    private static final String TEXT_OR_LABEL_2 = "//*[@text='foo'] | //*[@label='foo']";

    // And operator
    private static final String AND1 = "//*[@text='some text' and @resource-id='some id']";
    private static final String AND2 = "//*[@text='some text'][@resource-id='some id']";
    private static final String AND3 = "//*[*[@text='some text']]";

    // Index (list position)
    private static final String POSITION_NUMBER = "//android.widget.FrameLayout[2]"; // 2-th item position on list.
    private static final String POSITION_LAST = "//android.widget.FrameLayout[last()]"; // Last item position on list.

    // Parent
    private static final String ANCESTOR_ = "//*[@text='some text']/ancestor::*[@resource-id='some id']"; // Ancestor with some id.
    private static final String ANCESTOR_NEAREST = "//*[@text='some text']/.."; // Nearest ancestor.

    // Descend
    private static final String DESCEND = "//*[@text='foo']//*[@text='bar']";
    private static final String DESCEND_NEAREST = "//*[@text='foo']/*[@text='bar']";

    // Grouping
    private static final String FIRST_IN_GROUP = "(//android.widget.TextView)[1]";
    private static final String LAST_IN_GROUP = "(//android.widget.TextView)[last()]";
    private static final String FIRST_OR_LAST_IN_GROUP = "(//android.widget.TextView)[position()=1 or position()=last()]";

}
