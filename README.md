# Brainy: Make-A-Story 
Brainy: Make-A-Story is an Android app designed to help children learn new words through fill-in-the-blank, read-aloud stories.
## Release Notes version Brainy Make-A-Story v1.0.0
### FEATURES
- Choose from 4 story templates
- Add words or characters to blanks in the story template
- Take quizzes to learn and unlock words
- Review quizzes for previously mastered words
- Play, pause, and replay story audio
- Save progress in a story template
- Share a completed story via email
    
### BUG FIXES
- New navigation components to maintain flow and correct state throughout application
- Updated all placeholder images to client provided images.
- User’s word or character selections in the story template screens are bolded. 
- Fixed formatting issues with story text.
- Replaced example story templates with client-provided templates.
- Story audio will pause when a blank is reached rather than playing through to the end.
- Story audio will resume from a blank upon returning from the word bank instead of starting back at the beginning. 
- Rewind will go back 15 seconds rather than to the beginning of the story.
- Updated view of home screen with client provided images. "Friends" section has been removed.
    
### KNOWN BUGS
- Sharing feature currently only involves story text and mastered word list. 
- No autoscroll. When returning to a story template from the word bank/character selection screens, the story text position resets to the beginning rather than the location of the blank.
- Progress bar on story pages will momentarily be empty when returning to the story template screen from the word bank. Once audio resumes, progress bars will return to the correct state.
- Mediaplayer isn’t shared across all pages of one story template.
- Wrong images are displayed for words without corresponding image in res.
    

## Install Guide 

### PRE-REQUISITES
Download Android Studio and SDK Tools. See [link](https://developer.android.com/studio)
### DEPENDENCIES
Dependencies are included in gradle files from “DOWNLOAD”
### DOWNLOAD
Download or clone [link](https://github.com/adelventura/Brainy-Make-A-Story-Android.git) and open project in Android Studio
##### Using Version Control:
1. Open Android Studio
2. Go to:
File -> New -> Project from Version Control -> Git
3. Paste the repository URL https://github.com/adelventura/Brainy-Make-A-Story-Android.git
4. Choose a directory to clone the project into.
5. Select Clone
### BUILD
Build and run “Brainy-Make-A-Story-Android/prototype/” in Android Studio. See [link](https://developer.android.com/studio/run)
### INSTALLATION
- Connect an Android device via USB. See [link](https://developer.android.com/studio/run/device#connect) or 
- Create an AVD to use Android Emulator. See [link](https://developer.android.com/studio/run/managing-avds#createavd)
### RUNNING APPLICATION
The app will launch automatically in the chosen device
### TROUBLESHOOTING
If many errors suddenly appear in the code or if the app keeps crashing, try
- Build → Clean Project or
- File → Sync Project with Gradle Files or
- File → Invalidate Caches / Restart

If the emulated device is not working (crashing, freezing, taking a long time to load), try
- Open AVD Manager → Actions → Wipe Data

If story audio cannot be heard
- Make sure the laptop/computer volume is turned up enough, or try using earbuds
