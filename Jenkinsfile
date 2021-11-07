pipeline {
    agent any
    tools{
        maven 'M2_HOME'
    }
    stages {
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
                }
            }
        }
        stage('reports') {
            steps {
                script {
                   allure results: [[path: 'allure-results']]
                }
            }
        }
    }
}
