def call(){
pipeline {
    agent any
    
    stages {
         def p = pipelineConfig()
        
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
