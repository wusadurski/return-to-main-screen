package com.wsadurski.returntomainscreen.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet

class UserInteractionEditText : android.support.v7.widget.AppCompatEditText {

    constructor(context: Context) : super(context)

    constructor(
            context: Context,
            attrs: AttributeSet
    ) : super(context, attrs)

    constructor(
            context: Context,
            attrs: AttributeSet,
            defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr)

    override fun onTextChanged(
            text: CharSequence,
            start: Int,
            lengthBefore: Int,
            lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        (context as? Activity)?.onUserInteraction()
    }
}
