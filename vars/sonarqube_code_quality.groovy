def call(){
    timeout(time: 10, unit: "MINUTES"){   // increased from 1 to 10 minutes
        def qg = waitForQualityGate abortPipeline: true
        if (qg.status != 'OK') {
            error "❌ Pipeline aborted due to Quality Gate failure: ${qg.status}"
        } else {
            echo "✅ Quality Gate passed: ${qg.status}"
        }
    }
}
