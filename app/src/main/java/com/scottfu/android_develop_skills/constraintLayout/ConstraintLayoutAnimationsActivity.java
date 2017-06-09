package com.scottfu.android_develop_skills.constraintLayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

import com.scottfu.android_develop_skills.R;

/**
 * Created by fujindong on 2017/6/9.
 */

public class ConstraintLayoutAnimationsActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_animations);
        constraintLayout = (ConstraintLayout) findViewById(R.id.cl_content);
        resetConstraintSet.clone(constraintLayout);
        applyConstraintSet.clone(constraintLayout);

    }
    @TargetApi(19)
    public void onResetClick(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition(constraintLayout);
        }
        resetConstraintSet.applyTo(constraintLayout);
    }

    /**
     * 当前设置的最低版本api为14
     * @TargetApi(?) 是为了让lint 在检查变异时通过，具体在执行代码的位置还是要判断当前版本的是否执行代码
     * TransitionManager 在api19开始才支持
     *
     * 或者添加support library
     * compile 'com.android.support:transition:25.1.0'
     * @param view
     */
    @TargetApi(19)
    public void onApplyClick(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition(constraintLayout);
        }

//        setMargin();

//        setCenterHorizontally();
//        setCenterHorizontallyVertically();
//        setWidthHeight();

//        setVisibilityAndClearAndConnect(); //隐藏其他按钮 让b13 按钮铺满整个屏幕

        setHorizontalChain();




        applyConstraintSet.applyTo(constraintLayout);
    }

    private void setHorizontalChain() {
        applyConstraintSet.clear(R.id.button8);
        applyConstraintSet.clear(R.id.button9);
        applyConstraintSet.clear(R.id.button10);

        applyConstraintSet.connect(R.id.button8, ConstraintSet.LEFT,R.id.cl_content,ConstraintSet.LEFT,0);
        applyConstraintSet.connect(R.id.button10,ConstraintSet.RIGHT,R.id.cl_content,ConstraintSet.RIGHT,0);

        applyConstraintSet.connect(R.id.button9, ConstraintSet.LEFT, R.id.button8, ConstraintSet.RIGHT, 0);
        applyConstraintSet.connect(R.id.button8, ConstraintSet.RIGHT, R.id.button9, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.button9, ConstraintSet.RIGHT, R.id.button10, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.button10, ConstraintSet.LEFT, R.id.button9, ConstraintSet.RIGHT, 0);

//        createHorizontalChain 参数的官方说明与之前的版本有变动
//         leftId	int: The id of the widget to connect to or PARENT_ID
//        leftSide	int: the side of the start to connect to
//        rightId	int: The id of the widget to connect to or PARENT_ID
//        rightSide	int: the side of the right to connect to
//        chainIds	int: The widgets in the chain
//        weights	float: The weight to assign to each element in the chain or null
//        style	int: The type of chain
        applyConstraintSet.createHorizontalChain(R.id.cl_content,ConstraintSet.LEFT,R.id.cl_content,ConstraintSet.RIGHT,
                new int[]{R.id.button8,R.id.button9,R.id.button10},null, ConstraintWidget.CHAIN_PACKED);

        applyConstraintSet.constrainWidth(R.id.button8,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.button8,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainWidth(R.id.button9,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.button9,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainWidth(R.id.button10,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.button10,ConstraintSet.WRAP_CONTENT);

        applyConstraintSet.setHorizontalBias(R.id.button8, 0.8f);//设置偏移比例

    }

    /**
     * 隐藏其他按钮 让这个按钮铺满父控件
     * 这里要注意的是 ConstraintLayout 具有FrameLayout 的特性 如果铺满的是
     * 第一个放置的按钮 那么后面添加的按钮会显示在齐上面
     */
    private void setVisibilityAndClearAndConnect() {

        applyConstraintSet.setVisibility(R.id.button9, ConstraintSet.GONE);
        applyConstraintSet.setVisibility(R.id.button10, ConstraintSet.GONE);


//        没有约束关系的时候setMargin 是无效的
//        applyConstraintSet.setMargin(R.id.button13, ConstraintSet.START, 0);
//        applyConstraintSet.setMargin(R.id.button13, ConstraintSet.END, 0);
//        applyConstraintSet.setMargin(R.id.button13, ConstraintSet.TOP, 0);
//        applyConstraintSet.setMargin(R.id.button13, ConstraintSet.BOTTOM, 0);


        applyConstraintSet.clear(R.id.button13);//clear 的意思是清除此按钮所有constraint属性
        applyConstraintSet.connect(R.id.button13, ConstraintSet.LEFT, R.id.cl_content, ConstraintSet.LEFT, 0);//connect 连接两个控件的边缘并设置margin
        applyConstraintSet.connect(R.id.button13, ConstraintSet.RIGHT, R.id.cl_content, ConstraintSet.RIGHT, 0);
        applyConstraintSet.connect(R.id.button13, ConstraintSet.TOP, R.id.cl_content, ConstraintSet.TOP, 0);
        applyConstraintSet.connect(R.id.button13, ConstraintSet.BOTTOM, R.id.cl_content, ConstraintSet.BOTTOM, 0);
    }

    private void setWidthHeight() {
        //      设置按钮宽度／高度
        applyConstraintSet.constrainWidth(R.id.button8,600);
        applyConstraintSet.constrainHeight(R.id.button8,400);
    }

    private void setCenterHorizontallyVertically() {
        //        移动第按钮10 到父布局的中心
        applyConstraintSet.setMargin(R.id.button10, ConstraintSet.START, 0);
        applyConstraintSet.setMargin(R.id.button10, ConstraintSet.END, 0);
        applyConstraintSet.setMargin(R.id.button10, ConstraintSet.TOP, 0);
        applyConstraintSet.setMargin(R.id.button10, ConstraintSet.BOTTOM, 0);

        applyConstraintSet.centerHorizontally(R.id.button10, R.id.cl_content);
        applyConstraintSet.centerVertically(R.id.button10, R.id.cl_content);
    }

    private void setCenterHorizontally() {
        //        让三个按钮都水平居中
        applyConstraintSet.setMargin(R.id.button8, ConstraintSet.START,0);
        applyConstraintSet.setMargin(R.id.button8,ConstraintSet.END,0);
        applyConstraintSet.setMargin(R.id.button9,ConstraintSet.START,0);
        applyConstraintSet.setMargin(R.id.button9,ConstraintSet.END,0);
        applyConstraintSet.setMargin(R.id.button10,ConstraintSet.START,0);
        applyConstraintSet.setMargin(R.id.button10,ConstraintSet.END,0);

        applyConstraintSet.centerHorizontally(R.id.button8,R.id.cl_content);
        applyConstraintSet.centerHorizontally(R.id.button9,R.id.cl_content);
        applyConstraintSet.centerHorizontally(R.id.button10,R.id.cl_content);
    }

    private void setMargin() {
        //        设置边距
        applyConstraintSet.setMargin(R.id.button8, ConstraintSet.START, 8);
    }



}
