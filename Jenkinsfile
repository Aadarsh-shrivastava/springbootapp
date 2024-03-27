pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'OpenJDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'git-credentials', url: 'https://github.com/Muskankhoiya/springbootapp.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    bat 'mvn test'
                }
            }
        }
    }
}
