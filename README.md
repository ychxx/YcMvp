# YcMvp
Android开发框架
MVP+RxJava2+Retrofit2+OkHttp3

#配置
在整个工程的build.gradle添加
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
}
在主项目(通常是app项目下)的build.gradle添加
dependencies {
		implementation 'com.github.ychxx:YcMvp:1.0.1'
        /* view依赖注入 */
        implementation 'com.jakewharton:butterknife:8.6.0'
        annotationProcessor 'com.jakewharton:butterknife-compiler:8.6.0'
}

