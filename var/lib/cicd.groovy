def continounDownload(repo)
{
  git "https://mave//${repo}.git"
}
def continousBuild()
{
  sh 'mvn package'
}
def continusDeploy(jobname,ip,contextname)
{
  sh "scp /home/ubuntu/.jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapp/${contextname}.war"
}
def continousExecute(jobname)
{
  sh "java -jar /home/ubuntu/jenkins/workspace/${jobname}/testing.jar"
}

def newDownload(repo)
{
 git "https://github.com/intelliqittrainings/${repo}"
}
def newBuild()
{
 sh 'mvn package'
}
def newDeploy(jobname,ip,contextname)
{
 sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war 
ubuntu@${ip}:/var/lib/tomcat9/webapps/${contextname}.war"
}
def runSelenium(jobname)
{
sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
