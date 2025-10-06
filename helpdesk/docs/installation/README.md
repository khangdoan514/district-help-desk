# **Installation**

## **Installation for macOS**

#### 1. [Java Development Kit (JDK) 23](https://www.oracle.com/java/technologies/downloads/) (or higher)

- Visit the [Oracle JDK download page](https://www.oracle.com/java/technologies/downloads/) and choose the appropriate installer for your operating system

- Download the JDK and run the installer (use defaults)

- List all installed JDKs

```bash
/usr/libexec/java_home -V
```

- Example output

```bash
Matching Java Virtual Machines (1):
    24.0.2 (arm64) "Oracle Corporation" - "Java SE 24.0.2" /Library/Java/JavaVirtualMachines/jdk-24.jdk/Contents/Home
```

- Restart the terminal and verify

```bash
java -version
```

#### 2. [Apache Maven 3.9+](https://maven.apache.org)

- Visit the [Maven download page](https://maven.apache.org/download.cgi)

- Under **Files**, download `Binary zip archive (apache-maven-3.9.X-bin.zip)` and unzip

- Add to `~/.zshrc` or `~/.bashrc`

```bash
export MAVEN_HOME=/opt/apache-maven-3.9.X       # or /opt/maven if symlink
export PATH=$MAVEN_HOME/bin:$PATH
```

- Reload

```bash
source ~/.zshrc     # or ~/.bashrc
```

- Restart the terminal and verify

```bash
mvn -v
```

## **Installation for Windows**

#### 1. [Java Development Kit (JDK) 23](https://www.oracle.com/java/technologies/downloads/) (or higher)

- Visit the [Oracle JDK download page](https://www.oracle.com/java/technologies/downloads/) and choose the appropriate installer for your operating system

- Download the JDK and run the installer (use defaults)

- Save the folder to `C:\Program Files\Java\jdk-23` (replace "23" with your version)

- Open **Start Menu** → Search for **Edit the system environment variables**

- Select **Environment Variables**. Under **System variables**
  
    - Select **New**
        
        - Variable name: `JAVA_HOME`

        - Variable value: `C:\Program Files\Java\jdk-23` (replace "23" with your version)
    
    - Find `Path` variable
    
        - Select **Edit** → Select **New** → Add `%JAVA_HOME%\bin`

- Restart the terminal and verify

```bash
java -version
```

#### 2. [Apache Maven 3.9+](https://maven.apache.org)

- Visit the [Maven download page](https://maven.apache.org/download.cgi)

- Under **Files**, download `Binary zip archive (apache-maven-3.9.X-bin.zip)` and extract

- Save the folder to `C:\Program Files\apache-maven-3.9.X` (replace "X" with your version)

- Open **Start Menu** → Search for **Edit the system environment variables**

- Select **Environment Variables**. Under **System variables**
  
    - Select **New**
        
        - Variable name: `MAVEN_HOME`

        - Variable value: `C:\Program Files\apache-maven-3.9.X` (replace "X" with your version)
    
    - Find `Path` variable
    
        - Select **Edit** → Select **New** → Add `%MAVEN_HOME%\bin`

- Restart the terminal and verify

```bash
mvn -v
```

## **Installation for both macOS and Windows**

#### 1. [Git](https://git-scm.com)

- Visit the [Git download page](https://git-scm.com/downloads) and choose the appropriate installer for your operating system

- Download and run the installer (use defaults)

#### 2. [SceneBuilder](https://gluonhq.com/products/scene-builder/)

- Visit the [SceneBuilder download page](https://gluonhq.com/products/scene-builder/) and choose the appropriate installer for your operating system

- Download and run the installer (use defaults)