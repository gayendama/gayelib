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
                    def p = pipelineConfig()
                    build([
                        IMAGE_NAME: p.IMAGE_NAME,
                        DOCKER_ID: p.DOCKER_ID
                    ]) // Appeler la méthode avec un Map
            }
        }
    }
}
}
