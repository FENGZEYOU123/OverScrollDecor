# OverScrollDecor
###类似IOS的over-scrolling效果，即对于滑动到顶部的View继续滑动时会超出，松手后自动还原到原始位置。支持ListView，GridView，ScrollView，WebView，RecyclerView，以及其他的任意View和ViewGroup。

欢迎大家下载体验本项目，如果使用过程中遇到什么问题，欢迎反馈。

### 联系方式
 * 邮箱地址： liaojeason@126.com
 * QQ群： 489873144 （建议使用QQ群，邮箱使用较少，可能看的不及时）
 * 本群刚建立，旨在为使用我的github项目的人提供方便，如果遇到问题欢迎在群里提问。个人能力也有限，希望一起学习一起进步。


## 演示
 ![image](https://github.com/jeasonlzy0216/OverScrollDecor/blob/master/screenshots/demo0.png)![image](https://github.com/jeasonlzy0216/OverScrollDecor/blob/master/screenshots/demo2.gif)![image](https://github.com/jeasonlzy0216/OverScrollDecor/blob/master/screenshots/demo3.gif)

## 1.用法
该项目和我github上其他的view相关的项目已经一起打包上传到jCenter仓库中（源码地址 [https://github.com/jeasonlzy0216/ViewCore](https://github.com/jeasonlzy0216/ViewCore) ），使用的时候可以直接使用compile依赖，用法如下
```java
	compile 'com.lzy.widget:view-core:0.1.9'
```
或者使用
```java
    compile project(':overscroll')
```

## 2.实现原理 
采用ViewDragHelper 和重写布局的 dispatchTouchEvent实现。

## 3.代码参考
### 使用简单，Java代码无需做任何修改，需要要将想要实现效果的布局外包一层`OverScrollDecor`即可。对于 ListView，GridView，ScrollView，WebView，RecyclerView 五个类需要使用该项目中提供的 Vertical开头的对应类，其余View 和 ViewGroup 使用原生即可。如果是自定义的 ListView（其余类似）,只需要将你自定义的ListView 继承 `VerticalListView` ，在不修改代码的情况下同样可以实现。
```xml
	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent">
	
	    <com.lzy.ui.OverScrollDecor
	        android:layout_width="match_parent"
	        android:layout_height="match_parent">
	
	        <com.lzy.ui.VerticalListView
	            android:id="@+id/listView"
	            android:layout_width="match_parent"
	            android:layout_height="match_parent"/>
	    </com.lzy.ui.OverScrollDecor>
</RelativeLayout>
```
