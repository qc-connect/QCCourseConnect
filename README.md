Group Project - README
===

# QC Class Connect

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
QC Class Connect will be a mobile application designed to connect students in their class in real time.  The application is designed for students to post questions and queries they have for a class based on the lecture.  Students can reply to the question, and look at past answers related to the topic based on a tagging system associated with each question. 

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Study Tool/ Social
- **Mobile:**  Mobile only experience, will not have a website component
- **Story:** Allows users to 
- **Market:** Any student that is a CS major can use the application. Using the hashtag search function students can focalize their study habits and connect with other students as needed
- **Habit:** Users can post and reply at an time as long as they are registered for the course
- **Scope:** Currently the application will be limited to the Computer Science major only at Queens College, however the application can be expanded to othr majors and hopefully to other schools thereater. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can log in based on QC ID Number
* User can enroll themselves into their course on the app
* User can post a question or comment in the chat room
* User can search hashtags for other related questions
* ...

**Optional Nice-to-have Stories**

* User can add a profile picture for their account
* Users can vote for an answers usefulness
* Users can sort hashtags by voting system
* User can create sub groups based on the initial chat room
* User can add friends that also have accounts
* Users will have titles/flairs associated with their name based on various accolades (Finished the course previously, Professor, etc.)
* ...

### 2. Screen Archetypes

* Login Screen
   * User can login
* Registration Screen
    * User can create an account
* Course Screen
   * User sees courses they are enrolled in
* Course Search Screen
   * User can search the database for their course and section to enroll
* Chat Screen
    * User can post a comment and respond to other's comments
* Search
    * User can parse the hashtags used throughout the cousre chat and review all replies to the post
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Chat Screen
* Search

**Flow Navigation** (Screen to Screen)

* Login Screen
   * => Home
* Registration Screen
    * => Home
* Course Screen
    * => Course Search Screen
   * => Chat Screen
* Course Search Screen
    * => Course Screen
* Chat Screen
    * => Search

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://i.imgur.com/xp9uOL4.png">

## Schema

### Models

* Model: User

| Property | Type | Description |
| -------- | -------- | -------- |
| name     | String     | unique username     |
| password | String | password of user|
|gradeLevel | String | current grade level|
|major | String | current grade level|
|coursesEnrolled| Integer Array | array of course id's the user is currently enrolled in|

* Model: Course

| Property | Type | Description |
| -------- | -------- | -------- |
| courseNum| Integer     | Course number|
|courseCode| Integer | Unique id of course|
|professor | String | Name of instructor|
|days | String | Meeting days of course | 
|time | String | Meeting time of course | 
|section | Integer | Section number of course | 

* Model: Post

| Property | Type | Description |
| -------- | -------- | -------- |
| postId     | Integer     | Unique id of post | 
|user | Pointer to User | Post author | 
|text | String | Content of post | 
|hashtag | String | Non-unique searchable id of post | 
|timeCreated | DateTime | Date post was created | 

* Model: List

| Property | Type | Description |
| -------- | -------- | -------- |
| listId     | Integer     | Unique id of list |
| postId | Array of Pointers to Posts | Contains all post ids belonging to the list | 

* Model: Hashtag

| Property | Type | Description |
| -------- | -------- | -------- |
| id     | Integer     | Unique id of hashtag | 
|tag | String | Hashtag name | 

### Networking
List of network requests by screen

* Login Screen
    * (Read/GET) Validate user log-in and password information with database

```
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });
    }
    private void login(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    // TODO: better error handling
                    Log.e(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
               }
                goMainActivity();
            }
        });
    }

```


* Account Creation Screen (Registration)
    * (Read/GET, Create/POST) Confirm username/password has not already been created in the database. Create new account in database if all information is valid
```
private void accountCreate(String userName, String password, String bio, String grade) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setBio(bio);
        user.setGrade(grade);
        user.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.d(TAG, "Error while saving");
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "Success!!");
            }
        });
    }
```
* Course Screen
    * (Read/GET) For the logged in user, display all courses associated with account
```
protected void queryCourses() {
        ParseQuery<Courses> postParseQuery = new ParseQuery<Courses>(Courses.class);
        postParseQuery.include(Post.KEY_USER);
        postParseQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Courses> posts, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                adapter.clear();
                mPosts.addAll(courses);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
                for(int i = 0; i < posts.size(); i++){
                    Courses course= posts.get(i);
                    Log.d(TAG, "Course: " + course.getCourseID() + ", Section: " +
                            course.getSection());
                }
            }
        });
    }
```
* Add Course Screen
    * (Read/GET) All courses in database are displayed
```
protected void queryCourses() {
        ParseQuery<Courses> postParseQuery = new ParseQuery<Courses>(Courses.class);
        postParseQuery.include(Post.KEY_MAJOR);
        postParseQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Courses> posts, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                adapter.clear();
                mPosts.addAll(courses);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
                for(int i = 0; i < posts.size(); i++){
                    Courses course= posts.get(i);
                    Log.d(TAG, "Course: " + course.getCourseID() + ", Section: " +
                            course.getSection());
                }
            }
        });
    }
```
* 
    * (Update/PUT) Courses user decides to enroll in are added to the user account
```
…. If enroll button.isClicked(){
	String courseCode = view.getCourse..getCourseCode();
	ParseUser currentUser = getCurrentUser();
addCourse(courseCode, currentUser);
	
}
Public boolean addCourse(String courseCode){
	Courses course = new Course(courseCode);
course.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.d(TAG, "Error while saving");
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "Success!!");

            }
        });
}
```
* Chat Screen
    * (Read/GET, Create/POST) User can post new messages and displays all messages that have been posted in the chat
```
protected void queryPosts() {
        ParseQuery<Post> postParseQuery = new ParseQuery<Post>(Post.class);
        postParseQuery.include(Post.KEY_CHATID);
        postParseQuery.setLimit(20);
        postParseQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postParseQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                adapter.clear();
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
                for(int i = 0; i < posts.size(); i++){
                    Post post = posts.get(i);
                    Log.d(TAG, "Post: " + post.getDescription() + ", Username: " +
                            post.getUser().getUsername());
                }
            }
        });
    }
```
* Parse Screen
    * (Read/GET) Shows all hashtags posted in the course chat
```
protected void queryPosts() {
        ParseQuery<Post> postParseQuery = new ParseQuery<Post>(Post.class);
//this parse is subject to change if voting system is implemented
//instead ordering by created at, would be ordered by amount of votes
        postParseQuery.include(Post.KEY_HASHTAG);
        postParseQuery.setLimit(20);
        postParseQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postParseQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                adapter.clear();
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
                for(int i = 0; i < posts.size(); i++){
                    Post post = posts.get(i);
                    Log.d(TAG, "Post: " + post.getDescription() + ", Username: " +
                            post.getUser().getUsername());
                }
            }
        });
    }
```

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype


