pipeline {
     agent any
     stages {
         stage('Build') {
             steps {
                  deleteDir()
                  checkout scm
             }
             post {
                 always {
                     jiraSendBuildInfo site: 'bashsquad.atlassian.net'
                 }
             }
         }
     }
 }
