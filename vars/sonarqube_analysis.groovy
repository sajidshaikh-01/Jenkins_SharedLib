def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}") {
      sh '''
        echo "Starting SonarQube analysis..."
        sonar-scanner \
          -Dsonar.projectKey=${ProjectKey} \
          -Dsonar.projectName=${Projectname} \
          -Dsonar.sources=. \
          -Dsonar.java.binaries=target/
      '''
  }
}
