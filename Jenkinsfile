pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clones the code from your GitHub repository
                git branch: 'main', url: 'https://github.com/saichaitanya50/EverestTechnologiesConsultancy.git'
            }
        }

        stage('Build') {
            steps {
                // Builds the project using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Runs the tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // This step could deploy to a server
                echo 'Deploying to production...'
            }
        }
    }
}
