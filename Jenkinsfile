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
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }

    }
}
