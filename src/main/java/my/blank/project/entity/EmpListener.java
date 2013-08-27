package my.blank.project.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class EmpListener implements EntityListener<Emp> {

    @Override
    public void preInsert(Emp entity, PreInsertContext context) {
    }

    @Override
    public void preUpdate(Emp entity, PreUpdateContext context) {
    }

    @Override
    public void preDelete(Emp entity, PreDeleteContext context) {
    }

    @Override
    public void postInsert(Emp entity, PostInsertContext context) {
    }

    @Override
    public void postUpdate(Emp entity, PostUpdateContext context) {
    }

    @Override
    public void postDelete(Emp entity, PostDeleteContext context) {
    }
}