pipeline {
 agent any
 tools {
 maven 'Maven'
 jdk 'Java 17'
 }
 stages {
 stage('Checkout') {
 steps {
 git branch: 'master', credentialsId: 'devgitpass', url: 'https://github.com/Aadarsh-shrivastava/devops'
 }
 }
 stage('Build') {
 steps {
 script {
 bat 'mvn clean package'
 }
 }

 }

 }
}
