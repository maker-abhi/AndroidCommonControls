pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Hello Jenkins!'
        bat '.\gradlew assembleDebug'
      }
    }
  }
}
