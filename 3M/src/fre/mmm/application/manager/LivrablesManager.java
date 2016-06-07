package fre.mmm.application.manager;

public interface LivrablesManager {

	public abstract void do_createNewVersion() throws Exception;

	public abstract void do_removeVersion() throws Exception;

	public abstract void do_createNewPatch() throws Exception;

	public abstract void do_addPatchToVersion() throws Exception;

	public abstract void do_removePatchToVersion() throws Exception;

}