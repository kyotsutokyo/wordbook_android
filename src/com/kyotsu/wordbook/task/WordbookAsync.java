package com.kyotsu.wordbook.task;

import android.os.AsyncTask;

public abstract class WordbookAsync<Params, Result, ExceptionType extends Exception>
		extends AsyncTask<Params, Void, WordbookAsync.ResultWrapper<Result, ExceptionType>>
{
    /// Wrapper around a result or exception
    static class ResultWrapper<Result, ExceptionType>
    {
        private Result result;
        private ExceptionType exception;
 
        private ResultWrapper(Result result, ExceptionType exception)
        {
            this.result = result;
            this.exception = exception;
        }
    }
 
    @SuppressWarnings("unchecked")
    @Override
    protected ResultWrapper<Result, ExceptionType> doInBackground(Params... args)
    {
        try
        {
            return new ResultWrapper<Result, ExceptionType>(run(args), null);
        }
        catch(Exception e) // Using generic ExceptionType in a catch block is not allowed
        {
            return new ResultWrapper<Result, ExceptionType>(null, (ExceptionType) e);
        }
    }
 
    @Override
    protected void onPostExecute(ResultWrapper<Result, ExceptionType> result)
    {
        if (result.exception == null)
            onSuccess(result.result);
        else
            onFailure(result.exception);
    }
 
    /**
     * Performs the background task.
     *
     * @param args
     * The parameters passed to execute.
     *
     * @return
     * The return value, passed to onSuccess.
     *
     * @throws ExceptionType
     * An exception, passed to onFailure.
     */
    abstract protected Result run(Params...args)
    throws ExceptionType;
 
    /**
     * Invoked when the background task finishes successfully.
     *
     * @param result
     * The result returned by run.
     */
    abstract protected void onSuccess(Result result);
 
    /**
     * Invoked when the background task thows an exception.
     *
     * @param exception
     * The exception thrown by run.
     */
    abstract protected void onFailure(ExceptionType exception);
}
