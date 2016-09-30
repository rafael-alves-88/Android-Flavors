
# Android-Flavors
Android Flavors allow you to compile different versions of the same app. You can also overlay resources and code for a specific flavor.

##1.Add the configuration to **build.gradle**

```xml
project.ext.set("packageName", "your.package.name")
project.ext.set("versionCode", 1)
project.ext.set("versionName", "1.0")

android {
    ...
    ...
    productFlavors {
        prod {
            applicationId project.packageName
            version project.versionName
            buildConfigField 'boolean', 'IS_BETA', 'false'
        }
        beta {
            applicationId project.packageName + ".beta"
            version project.versionName + "-beta"
            buildConfigField 'boolean', 'IS_BETA', 'true'
        }
    }
}
```

On **buildConfigField** property, you can add additional variables depending on your need.  
For example, you can create a tag for _'IS_PAYMENT_AVAILABLE'_ and in code only enable this feature for a specific flavor.


##2.Overlay Resources  
You can overlay App Icon and strings or code by creating an additional Layer.
- strings.xml:
main location: _**main/res/values/strings.xml**_  
flavor location: _**{{flavor_name}}/res/values/strings.xml**_  

**Obs**: Missing string tags from flavor's string.xml file will use them from main string.xml file, so it's not needed to overlay all of them.

- launcher_icon:
main location: _**main/res/drawable/mipmap/ic_launcher.png**_  
flavor location: _**{{flavor_name}}/res/drawable/mipmap/ic_launcher.png**_  

This way each flavor will have it's own resource.

##3.Check Flavor in Code

- This line of code will retrieve the current Flavor:
```java
String myFlavor = BuildConfig.FLAVOR;
```

- This line of code will check the variables added in _**buildConfigField**_ in _**build.gradle**_ file:
```java{
if (BuildConfig.IS_BETA) {
    doThis();
} else {
    doSomethingElse();
}
```
