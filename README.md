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
* Course Screen
    * => Course Search Screen
   * => Chat Screen
* Course Search Screen
    * => Course Screen
* Chat Screen
    * => Search

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
