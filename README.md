# LGMRoundButton

Android简易实现的圆形Button按钮，减少drawable实现圆形按钮方式书写太多的selector和drawable文件

# 效果图

![](/img/img1.png)

# 兼容性

API >= 21

# 集成方式

1. 在你的```Project build.gradle```下

```
allprojects {
    repositories {
        ....
   	maven { url 'https://jitpack.io' }
    }
}
```
2. 在```app build.gradle```下

```
dependencies {
    ....
    implementation 'com.github.minminaya:LGMRoundButton:v1.2'
}
```

# 使用方法
1、布局文件中直接添加
```
<com.minminaya.library.LGMRoundButton
               android:layout_width="wrap_content"
               android:layout_height="50dp"
               android:layout_centerInParent="true"
               android:gravity="center"
               android:padding="10dp"
               android:text="默认表现为圆角"
               app:borderColor="@color/Crimson_DC143C"
               app:borderWidth="2dp"
               app:isRadiusAutoHalf="true"
               app:textColorForPressed="@color/SlateGray_708090" />
               
```
![](/img/img2.png)

2、属性定义如下
```
<attr name="bgColor" format="color" /><!-- 当前背景颜色-->
<attr name="borderColor" format="color" /><!-- border线颜色-->
<attr name="textColorForPressed" format="color" /><!-- 按下button时字体颜色-->
<attr name="borderWidth" format="dimension" /><!-- border线宽，默认为1px，这里建议使用1dp或者2dp-->
<attr name="isRadiusAutoHalf" format="boolean" /><!-- 是否圆角半径裁为button短边一半-->
<attr name="alphaForDrawable" format="dimension" /><!--当前绘制的drawable的透明度-->
<attr name="radius" format="dimension" /><!-- 4个圆角半径-->
<attr name="radiusForTopLeft" format="dimension" /><!-- 圆角左上半径-->
<attr name="radiusForTopRight" format="dimension" /><!-- -->
<attr name="radiusForBottomLeft" format="dimension" /><!-- -->
<attr name="radiusForBottomRight" format="dimension" /><!-- -->
```

# 其他实现方式

Drawable定义为xml文件方式也可以实现

# License

Apache License 2.0
