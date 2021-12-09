pipeline {
     agent any
     stages {
         stage('Build') {
             steps {
                  deleteDir()
                  checkout scm
                  sh './gradlew clean build'
             }
             post {
                 always {
                     jiraSendBuildInfo site: 'bashsquad.atlassian.net'
                 }
             }
         }
     }
 }
