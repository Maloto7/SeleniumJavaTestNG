pipeline {
    agent any
    tools{
        maven 'M2_HOME'
        allure 'allure2'
    }
    stages {
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
                    allure results: [[path: 'allure-results']]
                    deleteDir()
                }
                failure {
                    slackSend message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} failed (<${env.BUILD_URL}|Open>)",
                            color: 'danger', teamDomain: 'qameta', channel: 'allure', tokenCredentialId: 'allure-channel'
                }
            }
        }

    }
}
