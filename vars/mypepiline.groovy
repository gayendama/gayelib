def call(){
pipeline {
    agent any
    
    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Auto discovery') {
            steps {
                script {
                    def p = pipelineConfig()
                    autoDiscovery(p)
                }
            }
        }
        stage('Build image docker') {
            steps {
                script {
                    buildDockerImage(p.IMAGE_NAME, p.DOCKER_ID)
                }
            }
        }
    }
}
}
