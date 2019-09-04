pipeline {
  agent any
  stages {
    stage('clean & install') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('deploy') {
      steps {
        sh 'mvn spring-boot:run'
      }
    }
  }
}