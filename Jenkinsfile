pipeline {
  agent {
    docker {
      image 'maven:3-alpine' 
      args '-v /root/.m2:/root/.m2' 
    }
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
     steps {
        sh 'mvn test'
     }
    }
    stage('Deliver') {
      steps {
        sh 'docker build -t spring-boot-mybatis-swagger-h2 . && docker run -d -p 1234:1234 --name spring-boot-mybatis-swagger-h2 spring-boot-mybatis-swagger-h2'
      }
    }
  }
}
