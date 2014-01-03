ScrollDetector
=============
ScrollDetector is a library for android developer to detect whether a view is scrollable, you can integrate it into your project which has custom view want to intercept touch event. this library can help you decide view touch event should be intercepted.

#Setup
1. Clone this project from [Github][1]
2. Import this library project into your eclipse workspace
3. Set your project properties, then add a android project library, and select ScrollDetector

#Usage
```java
ListView listView = new ListView(context);
Scrollable<ListView> scrollable = ScrollDetects.detect(listView);
scrollable.canScrollLeft();
scrollable.canScrollRight();
scrollable.canScrollUp();
scrollable.canScrollDown();

#Author
Tang Ke
tang.ke@me.com

#License
    Copyright (c) 2011-2014 Tang Ke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://www.github.com/TangKe/ScrollDetector.git
