# android-lib-dark-theme

How to use:-

# for gradle:-

Step 1-> Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2-> Add it in your app level build.gradle file

	dependencies {
	        implementation 'com.github.ablyGaganbhutani:android-lib-dark-theme:1.0.2'
	}

# for maven:-

Step 1:-
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2: Add the below dependency:-
	<dependency>
	    <groupId>com.github.ablyGaganbhutani</groupId>
	    <artifactId>android-lib-dark-theme</artifactId>
	    <version>1.0.2</version>
	</dependency>
	
	
# How to use:-

Add below line in application class:-
	// to fetch the dark theme value from shared preference
	
         setSelectedDarkModelValue()


General usage:-  
-> View.setSelectedIfDarkTheme() method of library to get whether dark mode is enabled or not
-> getIsDarkModeEnabled() method of library to get the value of status of dark mode from preference.  

	// to apply the dark mode on click of view
	 binding.layoutExpanded.switchDarkTheme.setOnClickListener {
            if (this.isEnabled()) {
                DarkTheme.apply(DarkModeEnum.off)
                this.launchActivity<DashboardActivity> { }
            } else {
                DarkTheme.apply(DarkModeEnum.on)
                this.launchActivity<DashboardActivity> { }
            }
        }

Use above code to switch between dark and light modes

Implement the interface UtilityDarkModeMethods to customise the below properties:-

-> color of TextView
-> color of DrawableTint
-> background color of any view

