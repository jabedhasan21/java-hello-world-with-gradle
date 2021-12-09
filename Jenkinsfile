pipeline {
     agent any
     stages {
         stage('Build') {
             steps {
                  deleteDir()
                  checkout scm
                  gradlew('assemble')
             }
             post {
                 always {
                     jiraSendBuildInfo site: 'bashsquad.atlassian.net'
                 }
             }
         }
     }
 }
