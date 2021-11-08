pipeline {
    agent any
    tools{
        maven 'M2_HOME'
    }
    stages {
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
            post {
                always {
                    step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
                    publishHTML (target : [allowMissing: false,
                     alwaysLinkToLastBuild: true,
                     keepAll: true,
                     reportDir: 'reports',
                     reportFiles: 'extent.html',
                     reportName: 'My Reports',
                     reportTitles: 'The Report'])
                     allure results: [[path: 'allure-results']]
                }
            }
        }

    }
}
