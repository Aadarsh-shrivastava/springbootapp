pipeline {
    agent any

    tools {
        // Define the tools to use
        maven 'maven'
        jdk 'OpenJDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Here you can add deployment steps if needed
            }
        }
    }

    post {
        success {
            echo 'Build and test successful!'
        }
        failure {
            echo 'Build or test failed!'
        }
    }
}
