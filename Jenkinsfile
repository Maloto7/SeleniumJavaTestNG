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
                success {
                    junit 'target/surefire-reports/testng-results.xml'
                }
            }
        }
    }
}
