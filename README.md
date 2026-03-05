# Video to Audio Converter (DevOps Project)

## 📌 Project Overview

This project is a **Video to Audio Converter Web Application** developed using **Java Spring Boot**.
The application allows users to upload a video file and convert it into an **MP3 audio file** using **FFmpeg**.

The project also demonstrates a **basic DevOps workflow**, including development, build, testing, and deployment.

---

# 🛠 Technologies Used

| Technology  | Purpose                              |
| ----------- | ------------------------------------ |
| Java        | Backend programming language         |
| Spring Boot | Web application framework            |
| Maven       | Build and dependency management tool |
| FFmpeg      | Video to audio conversion engine     |
| HTML        | Frontend structure                   |
| CSS         | UI styling                           |
| JavaScript  | Frontend interaction                 |
| Git         | Version control                      |
| VS Code     | Development environment              |

---

# 📂 Project Structure

video-audio
│
├── src
│   ├── main
│   │   ├── java/com/example/video_audio
│   │   │   ├── VideoAudioApplication.java
│   │   │   └── VideoController.java
│   │   │
│   │   └── resources
│   │       ├── static
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── script.js
│   │       │
│   │       └── application.properties
│
├── uploads
│   ├── input.mp4
│   └── output.mp3
│
├── pom.xml
└── README.md

---

# ⚙️ Prerequisites

Before running the project, install the following:

1. **Java JDK 17 or later**
2. **Maven**
3. **FFmpeg**
4. **Git (optional)**

Check installation using:

java -version
mvn -version
ffmpeg -version

---

# ▶️ How to Run the Project

### Step 1: Clone the Repository

git clone https://github.com/yourusername/video-audio-converter.git

cd video-audio

---

### Step 2: Create Upload Folder

Create a folder called:

uploads

inside the project directory.

---

### Step 3: Run the Application

Use Maven to start the Spring Boot server:

mvnw.cmd spring-boot:run

or

mvn spring-boot:run

---

### Step 4: Open the Application

Open your browser and go to:

http://localhost:8080

---

### Step 5: Convert Video

1. Click **Choose File**
2. Select a **.mp4 video**
3. Click **Convert**
4. The system will convert the video into **MP3**
5. The audio file will be downloaded automatically

---

# 🔄 DevOps Lifecycle Used

The project follows a simplified **DevOps lifecycle**:

Plan → Code → Build → Test → Release → Deploy → Operate → Monitor

Tools used in each stage:

Plan – Project planning
Code – Java, HTML, CSS, JavaScript
Build – Maven
Test – Manual testing
Release – GitHub version control
Deploy – Spring Boot local server
Operate – User uploads video
Monitor – Spring Boot logs

---

# 📊 Application Workflow

User Uploads Video
↓
Frontend sends video to Spring Boot API
↓
Backend stores video in uploads folder
↓
FFmpeg converts video → MP3
↓
Audio file returned to user for download

---

# 🚀 Future Improvements

• Drag and drop video upload
• Support multiple audio formats (MP3, WAV, AAC)
• Docker containerization
• CI/CD pipeline using GitHub Actions
• Cloud deployment (AWS / Azure)



Raksha R
DevOps Mini Project – Video to Audio Converter
