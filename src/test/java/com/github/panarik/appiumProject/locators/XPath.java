package com.github.panarik.appiumProject.locators;

public class XPath {

    //find view
    private static final String VIEW = "//androidx.recyclerview.widget.RecyclerView"; //find view by className

    //Single
    private static final String PARAMETER_TEXT_EXACT = "//*[@text='some text']"; //by text
    private static final String PARAMETER_TEXT_CONTAINS = "//*[contains(@text,'some text')]"; //by text

    //or
    private static final String TEXT_OR_LABEL = "//*[@text='foo' or @label='foo']";

    //and
    private static final String AND = "//ancestor::*[*[@text='foo']][@text='bar']";

    //index (list position)
    private static final String POSITION_NUMBER = "//*[@class='android.widget.FrameLayout'][1]"; //2-th position on list FrameLayout views

    //descend
    private static final String DESCEND = "//*[@name='foo']//*[@name='bar']";
    private static final String DESCEND_NEAREST = "//*[@name='foo']/*[@name='bar']";

    //combine
    private static final String COMBINE = "//*[@class='someName' or @label='someLabel'][2]/*[@test='some text']"; //find view with text some text in nearest parent. Parent has 3-th view in RecycleView
}
