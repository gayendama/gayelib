def call(){
pipeline {
    agent any
    environment {
       def p = pipelineConfig()
    }

    
    stages {
                
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Auto discovery') {
            steps {
                script {
                    autoDiscovery(p)
                }
            }
        }
        stage('Build image docker') {
            steps {
                script {
                    build(p.IMAGE_NAME, p.DOCKER_ID)
                }
            }
        }
    }
}
}
