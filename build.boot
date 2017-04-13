(set-env!
  :resource-paths #{"src" "resources"})


(task-options!
  pom    {:project 'rowtr/rowtr-css
          :version "0.1.2"
          :description "common css for rowtr projects"}
  speak  {:theme "woodblock"})

(deftask build-jar
  []
  (comp
    (pom)
    (jar)))

(deftask install-jar []
  (comp
    (build-jar)
    (install)))
