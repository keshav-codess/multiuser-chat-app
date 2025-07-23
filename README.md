<h1 align="center">🌐 EchoSphere</h1>
<h3 align="center">A Real-Time Multi-User Chat Application Built in Java</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Socket--Based-orange?style=flat-square&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Swing-GUI-blue?style=flat-square&logo=windows&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-Database-lightblue?style=flat-square&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/Eclipse-Project-purple?style=flat-square&logo=eclipse-ide&logoColor=white" />
</p>

---

## ✨ Overview

**EchoSphere** is a desktop-based group chat application that lets multiple users connect and chat in real-time using a server-client architecture. It features a beautiful GUI built with Java Swing, user authentication via MySQL, and live socket communication.


---

## 🔥 Features

- 🧑‍🤝‍🧑 Real-time multi-user group chat
- 🔐 User login/signup with MySQL integration
- 🎨 Swing-based clean and interactive UI
- 🧠 Multi-threaded server handling multiple clients
- 📦 Lightweight and easy to run
- ⏰ Live date & time in dashboard
- 💬 Typing/loading animations

---

## 🧰 Tech Stack

| Layer       | Technology     |
|-------------|----------------|
| 💻 Frontend | Java Swing     |
| 🛠 Backend  | Java (Sockets) |
| 🗃 Database | MySQL          |
| 🧠 Logic    | Multithreaded Server |
| ☁️ Hosting  | Localhost      |

---

<details>
<summary>📁 Project Structure (Click to expand)</summary>

<pre>
multiuserchatapp/
├── src/                          # All Java source files
│   └── com.codess.chatapp/      # Project package
│       ├── views/               # UI components (Login, Signup, Dashboard)
│       ├── network/             # Client, Server, Workers
│       └── utils/               # DB, Config, Helpers
├── bin/                         # Compiled .class files
├── mysql-connector-j-9.2.0.jar  # MySQL JDBC driver
├── .classpath                   # Eclipse classpath config
├── .project                     # Eclipse project config
└── README.md                    # You're here!
</pre>

</details>


---

## 🖼️ Screenshots

> *(Add screenshots here)*

| Login Screen | Chat Window |
|--------------|-------------|
| ![login](https://your-screenshot-link.com) | ![chat](https://your-screenshot-link.com) |

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/keshav-codess/multiuser-chat-app.git
cd echosphere
```

---

### 2️⃣ Set Up MySQL Database

- Create a database named: `chatapp`
- Run the SQL script from your `utils/` package (if available)  
  _or manually create the user table_
- Update credentials in:

```properties
utils/db.config.properties
```

---

### 3️⃣ Run the Application

🔧 **Open the project in Eclipse IDE**

1. Start the `Server.java` file  
2. For each client instance, run:

```java
UserScreen.java
```

---

## 🙌 Acknowledgements

- 💻 Java Swing inspiration from [Oracle Swing Docs](https://docs.oracle.com/javase/tutorial/uiswing/)
- 🐬 JDBC & MySQL Integration from [MySQL Official Docs](https://dev.mysql.com/doc/)
- ✨ UI Icons & Graphics from [Flaticon](https://www.flaticon.com/)

---

### 👨‍💻 Author

👨‍💻 Made with ❤️ by [Keshav](https://github.com/keshav-codess)
If you liked this project, consider ⭐ starring the repo and sharing it — _it helps a lot!_

